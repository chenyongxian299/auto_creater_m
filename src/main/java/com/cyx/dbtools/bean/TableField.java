package com.cyx.dbtools.bean;

public class TableField {
    private String fieldName;

    private String fieldType;

    private boolean enabledNull;

    private boolean isPrimaryKey;

    private String defaultValue;

    private String extra;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isEnabledNull() {
        return enabledNull;
    }

    public void setEnabledNull(boolean enabledNull) {
        this.enabledNull = enabledNull;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
