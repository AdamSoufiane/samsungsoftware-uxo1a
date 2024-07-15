package ai.shreds.shared; 
  
 import java.util.List; 
 import ai.shreds.domain.DomainPostEntity; 
 import ai.shreds.shared.SharedRequestParams; 
  
 public interface PostRepositoryPort { 
     List<DomainPostEntity> findAll(SharedRequestParams params); 
     DomainPostEntity findById(Long id); 
     DomainPostEntity findBySlug(String slug); 
 }