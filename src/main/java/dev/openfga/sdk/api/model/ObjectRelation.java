/*
 * OpenFGA
 * A high performance and flexible authorization/permission engine built for developers and inspired by Google Zanzibar.
 *
 * The version of the OpenAPI document: 0.1
 * Contact: community@openfga.dev
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package dev.openfga.sdk.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * ObjectRelation
 */
@JsonPropertyOrder({ObjectRelation.JSON_PROPERTY_OBJECT, ObjectRelation.JSON_PROPERTY_RELATION})
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        date = "2023-08-28T14:41:07.855252Z[Etc/UTC]")
public class ObjectRelation {
    public static final String JSON_PROPERTY_OBJECT = "object";
    private String _object;

    public static final String JSON_PROPERTY_RELATION = "relation";
    private String relation;

    public ObjectRelation() {}

    public ObjectRelation _object(String _object) {
        this._object = _object;
        return this;
    }

    /**
     * Get _object
     * @return _object
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_OBJECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getObject() {
        return _object;
    }

    @JsonProperty(JSON_PROPERTY_OBJECT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setObject(String _object) {
        this._object = _object;
    }

    public ObjectRelation relation(String relation) {
        this.relation = relation;
        return this;
    }

    /**
     * Get relation
     * @return relation
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RELATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getRelation() {
        return relation;
    }

    @JsonProperty(JSON_PROPERTY_RELATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * Return true if this ObjectRelation object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObjectRelation objectRelation = (ObjectRelation) o;
        return Objects.equals(this._object, objectRelation._object)
                && Objects.equals(this.relation, objectRelation.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_object, relation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ObjectRelation {\n");
        sb.append("    _object: ").append(toIndentedString(_object)).append("\n");
        sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Convert the instance into URL query string.
     *
     * @return URL query string
     */
    public String toUrlQueryString() {
        return toUrlQueryString(null);
    }

    /**
     * Convert the instance into URL query string.
     *
     * @param prefix prefix of the query string
     * @return URL query string
     */
    public String toUrlQueryString(String prefix) {
        String suffix = "";
        String containerSuffix = "";
        String containerPrefix = "";
        if (prefix == null) {
            // style=form, explode=true, e.g. /pet?name=cat&type=manx
            prefix = "";
        } else {
            // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
            prefix = prefix + "[";
            suffix = "]";
            containerSuffix = "]";
            containerPrefix = "[";
        }

        StringJoiner joiner = new StringJoiner("&");

        // add `object` to the URL query string
        if (getObject() != null) {
            joiner.add(String.format(
                    "%sobject%s=%s",
                    prefix,
                    suffix,
                    URLEncoder.encode(String.valueOf(getObject()), StandardCharsets.UTF_8)
                            .replaceAll("\\+", "%20")));
        }

        // add `relation` to the URL query string
        if (getRelation() != null) {
            joiner.add(String.format(
                    "%srelation%s=%s",
                    prefix,
                    suffix,
                    URLEncoder.encode(String.valueOf(getRelation()), StandardCharsets.UTF_8)
                            .replaceAll("\\+", "%20")));
        }

        return joiner.toString();
    }
}
