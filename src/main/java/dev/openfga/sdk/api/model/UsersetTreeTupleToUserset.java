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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * UsersetTreeTupleToUserset
 */
@JsonPropertyOrder({UsersetTreeTupleToUserset.JSON_PROPERTY_TUPLESET, UsersetTreeTupleToUserset.JSON_PROPERTY_COMPUTED})
@javax.annotation.Generated(
        value = "org.openapitools.codegen.languages.JavaClientCodegen",
        date = "2023-08-28T14:41:07.855252Z[Etc/UTC]")
public class UsersetTreeTupleToUserset {
    public static final String JSON_PROPERTY_TUPLESET = "tupleset";
    private String tupleset;

    public static final String JSON_PROPERTY_COMPUTED = "computed";
    private List<Computed> computed = new ArrayList<>();

    public UsersetTreeTupleToUserset() {}

    public UsersetTreeTupleToUserset tupleset(String tupleset) {
        this.tupleset = tupleset;
        return this;
    }

    /**
     * Get tupleset
     * @return tupleset
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TUPLESET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public String getTupleset() {
        return tupleset;
    }

    @JsonProperty(JSON_PROPERTY_TUPLESET)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTupleset(String tupleset) {
        this.tupleset = tupleset;
    }

    public UsersetTreeTupleToUserset computed(List<Computed> computed) {
        this.computed = computed;
        return this;
    }

    public UsersetTreeTupleToUserset addComputedItem(Computed computedItem) {
        if (this.computed == null) {
            this.computed = new ArrayList<>();
        }
        this.computed.add(computedItem);
        return this;
    }

    /**
     * Get computed
     * @return computed
     **/
    @javax.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_COMPUTED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public List<Computed> getComputed() {
        return computed;
    }

    @JsonProperty(JSON_PROPERTY_COMPUTED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setComputed(List<Computed> computed) {
        this.computed = computed;
    }

    /**
     * Return true if this UsersetTree.TupleToUserset object is equal to o.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UsersetTreeTupleToUserset usersetTreeTupleToUserset = (UsersetTreeTupleToUserset) o;
        return Objects.equals(this.tupleset, usersetTreeTupleToUserset.tupleset)
                && Objects.equals(this.computed, usersetTreeTupleToUserset.computed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tupleset, computed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UsersetTreeTupleToUserset {\n");
        sb.append("    tupleset: ").append(toIndentedString(tupleset)).append("\n");
        sb.append("    computed: ").append(toIndentedString(computed)).append("\n");
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

        // add `tupleset` to the URL query string
        if (getTupleset() != null) {
            joiner.add(String.format(
                    "%stupleset%s=%s",
                    prefix,
                    suffix,
                    URLEncoder.encode(String.valueOf(getTupleset()), StandardCharsets.UTF_8)
                            .replaceAll("\\+", "%20")));
        }

        // add `computed` to the URL query string
        if (getComputed() != null) {
            for (int i = 0; i < getComputed().size(); i++) {
                if (getComputed().get(i) != null) {
                    joiner.add(getComputed()
                            .get(i)
                            .toUrlQueryString(String.format(
                                    "%scomputed%s%s",
                                    prefix,
                                    suffix,
                                    "".equals(suffix)
                                            ? ""
                                            : String.format("%s%d%s", containerPrefix, i, containerSuffix))));
                }
            }
        }

        return joiner.toString();
    }
}
