package kr.co.pawong.pwsb.lostPost.adapter.out.persistence.es.document;

import kr.co.pawong.pwsb.adoption.enums.SexCd;
import kr.co.pawong.pwsb.adoption.enums.UpKindCd;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "lost_animal")
public class LostAnimalDocument {

    @Id
    @Field(type = FieldType.Keyword, name = "lostAnimalId")
    private String lostAnimalId; // type + id // ex) LOST_13, FOUND_243

    @Field(type = FieldType.Keyword, name = "rdbId")
    private Long rdbId; // id

    @Field(type = FieldType.Keyword, name = "type")
    private String type; // LOST, FOUND, RESQUE

    @Field(type = FieldType.Keyword, name = "upKindCd")
    private UpKindCd upKindCd;

    @Field(type = FieldType.Keyword, name = "sexCd")
    private SexCd sexCd;

    @Field(type = FieldType.Keyword, name = "city")
    private String city;

    @Field(type = FieldType.Keyword, name = "district")
    private String district;

    @GeoPointField
    @Field(name = "geoPoint")
    private GeoPoint geoPoint;

    @Field(type = FieldType.Dense_Vector, dims = 512, name = "embedding")
    private float[] embedding;
}
