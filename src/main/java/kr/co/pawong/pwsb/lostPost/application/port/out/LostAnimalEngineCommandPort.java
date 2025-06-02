package kr.co.pawong.pwsb.lostPost.application.port.out;

public interface LostAnimalEngineCommandPort {

    void deleteLostAnimalByAdoptionId(Long adoptionId);
}
