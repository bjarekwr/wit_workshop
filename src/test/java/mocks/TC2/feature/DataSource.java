package mocks.TC2.feature;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import java.util.Collections;
import java.util.List;

@Builder
public class DataSource {

    @SerializedName("Id")
    public Integer id;
    @SerializedName("Parents")
    public List<Object> parents;
    @SerializedName("SourceUrl")
    public String sourceUrl;
    @SerializedName("Data")
    public List<Data> data;

    public static List<DataSource> getDefault() {
        return Collections.singletonList(
            DataSource.builder()
                .id(0)
                .data(Data.getDefault())
                .build());
    }
}
