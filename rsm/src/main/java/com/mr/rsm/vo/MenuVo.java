package com.mr.rsm.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName MenuVo
 * @Description: TODO
 * @Author adh
 * @Date 2020/7/22
 * @Version V1.0
 **/
@Data
public class MenuVo {

    private Integer mId;

    private String mName;

    private String mUri;

    private List<MenuVo> childList;

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmUri() {
        return mUri;
    }

    public void setmUri(String mUri) {
        this.mUri = mUri;
    }

    public List<MenuVo> getChildList() {
        return childList;
    }

    public void setChildList(List<MenuVo> childList) {
        this.childList = childList;
    }

    public MenuVo(Integer mId, String mName, String mUri) {
        this.mId = mId;
        this.mName = mName;
        this.mUri = mUri;
        this.childList = childList;
    }

    public MenuVo() {
    }

    @Override
    public String toString() {
        return "MenuVo{" +
                "mId=" + mId +
                ", mName='" + mName + '\'' +
                ", mUri='" + mUri + '\'' +
                ", childList=" + childList +
                '}';
    }
}
