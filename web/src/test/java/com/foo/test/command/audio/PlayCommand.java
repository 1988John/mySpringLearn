package com.foo.test.command.audio;

public class PlayCommand implements Command {
    private AudioPlayer audio;
    public PlayCommand(AudioPlayer audio) {
        this.audio = audio;
    }
    /**
     * 执行方法
     */
    @Override
    public void execute() {
        audio.play();
    }
}