package mocks.TC3.country;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.List;

@Builder
public class AddressSchema {

    @SerializedName("lookup_fields")
    public List<Object> lookupFields;
    @SerializedName("fields")
    public List<Field> fields;

    @SneakyThrows
    public static AddressSchema getDefaultSchema() {
        return AddressSchema.builder()
            .fields(Arrays.asList(
                Field.getAddressFlatNoField(),
                Field.getAddressBuildingField(),
                Field.getEmail(),
                Field.getMobile()))
            .build();
    }
}
