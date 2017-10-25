package cn.huashantech.liaoliao2.entity.po;

public class UserDeviceInfo {
    private Long id;

    private Long userId;

    private String did;

    private String appName;

    private String appVersion;

    private String deviceType;

    private String deviceHardware;

    private String deviceSystemVersion;

    private String scale;

    private String ip;

    private Integer deviceStatus = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceHardware() {
        return deviceHardware;
    }

    public void setDeviceHardware(String deviceHardware) {
        this.deviceHardware = deviceHardware == null ? null : deviceHardware.trim();
    }

    public String getDeviceSystemVersion() {
        return deviceSystemVersion;
    }

    public void setDeviceSystemVersion(String deviceSystemVersion) {
        this.deviceSystemVersion = deviceSystemVersion == null ? null : deviceSystemVersion.trim();
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Integer deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    @Override
    public String toString() {
        return "UserDeviceInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", did='" + did + '\'' +
                ", appName='" + appName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceHardware='" + deviceHardware + '\'' +
                ", deviceSystemVersion='" + deviceSystemVersion + '\'' +
                ", scale='" + scale + '\'' +
                ", ip='" + ip + '\'' +
                ", deviceStatus=" + deviceStatus +
                '}';
    }
}