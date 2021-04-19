package com.foo.test.command.audio;

public class RewindCommand implements Command {
    private AudioPlayer audio;
    public RewindCommand(AudioPlayer audio) {
        this.audio = audio;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        audio.rewind();
    }
}