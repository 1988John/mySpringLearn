//package com.foo.test.base;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.commons.collections4.MapUtils;
//import org.apache.commons.lang3.StringUtils;
//
//import com.kuaishou.customer.hotline.v3.helper.SimperfectResponse;
//import com.kuaishou.customer.hotline.v3.model.HotlineCallResource;
//import com.kuaishou.framework.util.ObjectMapperUtils;
//
///**
// * @author Fooisart
// * @date 10:20 20-03-2019
// */
//public class Test {
////CHECKSTYLE:OFF
//    public static void main(String[] args) {
//        String json = "{\n" +
//                "    \"resultEnum\": \"succ\",\n" +
//                "    \"message\": \"succ\",\n" +
//                "    \"data\": [\n" +
//                "        {\n" +
//                "            \"id\": 10712,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13613854808\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10713,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"15612339417\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10714,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"18028747401\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10715,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13052863630\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10716,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13684636292\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10717,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13473148233\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10718,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13625743333\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10719,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"18315271388\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10720,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13062082922\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10721,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13781608737\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10722,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13854883007\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10723,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"18254373456\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10724,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"15844019487\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10725,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13924111728\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10726,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13935269547\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10727,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"15541639000\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10728,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13779066826\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10729,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"17710345875\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10730,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"18280365216\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"id\": 10731,\n" +
//                "            \"outBoundTaskId\": 38,\n" +
//                "            \"createTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"creator\": \"运营-雷晓康\",\n" +
//                "            \"phoneNumber\": \"13772935922\",\n" +
//                "            \"custId\": null,\n" +
//                "            \"employeeId\": \"66515\",\n" +
//                "            \"state\": 1,\n" +
//                "            \"remark\": null,\n" +
//                "            \"appointmentTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"retryTimes\": null,\n" +
//                "            \"acceptTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"updateTime\": \"2019-01-17 11:07:01\",\n" +
//                "            \"extraInformation\": null\n" +
//                "        }\n" +
//                "    ],\n" +
//                "    \"resultCode\": 0\n" +
//                "}";
//        SimperfectResponse simperfectResponse = ObjectMapperUtils.fromJSON(json, SimperfectResponse.class);
//        simperfectResponse.setStatus(1);
//
//        List<Map<String, Object>> dataList = (List<Map<String, Object>>) simperfectResponse.getData();
//        if (CollectionUtils.isEmpty(dataList)) {
//            System.out.println("empty-1");
//        }
//
//        List<HotlineCallResource> list = dataList.stream()
//                .map(Test::buildHotlineCallResource)
//                .filter(Objects::nonNull)
//                .collect(Collectors.toList());
//
//        System.out.println(ObjectMapperUtils.toPrettyJson(list));
//    }
//
//    private static HotlineCallResource buildHotlineCallResource(Map<String, Object> dataMap) {
//        if (MapUtils.isEmpty(dataMap)) {
//            return null;
//        }
//
//        HotlineCallResource resource = new HotlineCallResource();
//        resource.setId(MapUtils.getLongValue(dataMap, "id", 0L));
//        resource.setTaskId(MapUtils.getLong(dataMap, "outBoundTaskId", null));
//        resource.setCreateTime(MapUtils.getString(dataMap, "createTime", StringUtils.EMPTY));
//        resource.setCreator(MapUtils.getString(dataMap, "creator", StringUtils.EMPTY));
//        resource.setPhoneNumber(MapUtils.getString(dataMap, "phoneNumber", StringUtils.EMPTY));
//        resource.setCustomerId(MapUtils.getString(dataMap, "custId", StringUtils.EMPTY));
//        resource.setEmployeeId(MapUtils.getString(dataMap, "employeeId", StringUtils.EMPTY));
//        resource.setState(MapUtils.getInteger(dataMap, "state", null));
//        resource.setRemark(MapUtils.getString(dataMap, "remark", StringUtils.EMPTY));
//        resource.setReserveTime(MapUtils.getString(dataMap, "appointmentTime", StringUtils.EMPTY));
//        resource.setRetryTimes(MapUtils.getInteger(dataMap, "retryTimes", null));
//        resource.setAcceptTime(MapUtils.getString(dataMap, "acceptTime", StringUtils.EMPTY));
//        resource.setUpdateTime(MapUtils.getString(dataMap, "updateTime", StringUtils.EMPTY));
//        resource.setExtension(MapUtils.getString(dataMap, "extraInformation", StringUtils.EMPTY));
//
//        return resource;
//    }
//}
