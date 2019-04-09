//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package wrx.xing;

import java.io.Serializable;

public class FinanceBillingJSFRequestMessage implements Serializable {
    private String version;
    private String dataType;
    private String charset;
    private int sourceId;
    private String data;
    private String checksum;

    public FinanceBillingJSFRequestMessage() {
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String toString() {
        return "FinanceBillingJSFRequestMessage{version='" + this.version + '\'' + ", dataType='" + this.dataType + '\'' + ", charset='" + this.charset + '\'' + ", sourceId=" + this.sourceId + ", data='" + this.data + '\'' + ", checksum='" + this.checksum + '\'' + '}';
    }
}
