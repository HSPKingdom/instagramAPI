package com.hackathon.instagram.module.Post.Elements.Image;

public class ImagePack {
    private Image lowResolution;
    private Image thumbnail;
    private Image standardResolution;

    public Image getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(Image lowResolution) {
        this.lowResolution = lowResolution;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Image getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(Image standardResolution) {
        this.standardResolution = standardResolution;
    }
}
