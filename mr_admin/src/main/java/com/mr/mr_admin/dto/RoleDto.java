package com.mr.mr_admin.dto;

import java.io.Serializable;

public class RoleDto implements Serializable {

    private String rlId;

    private String rlName;

    private String rlCode;

    public String getRlId() {
        return rlId;
    }

    public void setRlId(String rlId) {
        this.rlId = rlId;
    }

    public String getRlName() {
        return rlName;
    }

    public void setRlName(String rlName) {
        this.rlName = rlName;
    }

    public String getRlCode() {
        return rlCode;
    }

    public void setRlCode(String rlCode) {
        this.rlCode = rlCode;
    }
}
