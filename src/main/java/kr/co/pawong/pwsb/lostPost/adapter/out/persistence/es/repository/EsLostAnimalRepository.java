package kr.co.pawong.pwsb.lostPost.adapter.out.persistence.es.repository;

import kr.co.pawong.pwsb.lostPost.adapter.out.persistence.es.document.LostAnimalDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EsLostAnimalRepository extends ElasticsearchRepository<LostAnimalDocument, String> {
}
