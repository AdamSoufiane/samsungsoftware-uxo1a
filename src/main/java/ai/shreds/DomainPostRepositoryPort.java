package ai.shreds.domain.port; 
  
 import ai.shreds.shared.SharedRequestParams; 
 import ai.shreds.domain.entity.DomainPostEntity; 
 import java.util.List; 
  
 public interface DomainPostRepositoryPort { 
     List<DomainPostEntity> findAll(SharedRequestParams params); 
     DomainPostEntity findById(Long id); 
     DomainPostEntity findBySlug(String slug); 
 } 
 