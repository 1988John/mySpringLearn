package com.foo.test.zookeeper.demo1;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNoNodeException;

import com.alibaba.fastjson.JSON;

public class WorkServer {

    private ZkClient zkClient;
    private String configPath;
    private String serversPath;
    private ServerData serverData;
    private ServerConfig serverConfig;
    private IZkDataListener dataListener;

    public WorkServer(String configPath, String serversPath, ServerData serverData, ZkClient zkClient, ServerConfig initConfig) {
        this.zkClient = zkClient;
        this.configPath = configPath;
        this.serversPath = serversPath;
        this.serverData = serverData;
        this.serverConfig = initConfig;
        this.dataListener = new IZkDataListener() {
            public void handleDataDeleted(String dataPath) throws Exception {

            }

            public void handleDataChange(String dataPath, Object data)
                    throws Exception {
                String retJson = new String((byte[]) data);
                ServerConfig serverConfigLocal = (ServerConfig) JSON.parseObject(retJson, ServerConfig.class);
                updateConfig(serverConfigLocal);
                System.out.println("new Work server config is:" + serverConfig.toString());
            }
        };
    }

    public void start() {
        System.out.println("work server start...");
        initRunning();
    }

    public void stop() {
        System.out.println("work server stop...");
        zkClient.unsubscribeDataChanges(configPath, dataListener);
    }

    private void initRunning() {
        registMe();
        zkClient.subscribeDataChanges(configPath, dataListener);
    }

    private void registMe() {
        String mePath = serversPath.concat("/").concat(serverData.getAddress());

        try {
            zkClient.createEphemeral(mePath, JSON.toJSONString(serverData)
                    .getBytes());
        } catch (ZkNoNodeException e) {
            zkClient.createPersistent(serversPath, true);
            registMe();
        }
    }

    private void updateConfig(ServerConfig serverConfig) {
        this.serverConfig = serverConfig;
    }
}