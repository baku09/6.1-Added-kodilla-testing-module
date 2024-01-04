package com.kodilla.patterns.strategy.social;

public class SnapchatPublisher implements SocialPublisher{
    @Override
    public void share() {
        System.out.println("Snapchat");
    }
}
