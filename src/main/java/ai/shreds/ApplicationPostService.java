package ai.shreds.application; 
  
 import ai.shreds.domain.DomainPostEntity; 
 import ai.shreds.domain.DomainPostService; 
 import ai.shreds.domain.DomainPostRepositoryPort; 
 import ai.shreds.shared.SharedPostDTO; 
 import ai.shreds.shared.SharedRequestParams; 
 import org.springframework.beans.factory.annotation.Autowired; 
 import org.springframework.stereotype.Service; 
  
 import java.util.List; 
 import java.util.stream.Collectors; 
  
 @Service 
 public class ApplicationPostService implements ApplicationPostPort { 
  
     private final DomainPostRepositoryPort postRepository; 
     private final DomainPostService postLogic; 
  
     @Autowired 
     public ApplicationPostService(DomainPostRepositoryPort postRepository, DomainPostService postLogic) { 
         this.postRepository = postRepository; 
         this.postLogic = postLogic; 
     } 
  
     @Override 
     public List<SharedPostDTO> findAllPosts(SharedRequestParams params) { 
         List<DomainPostEntity> posts = postRepository.findAll(params); 
         posts = postLogic.applyFilters(posts, params); 
         posts = postLogic.sortPosts(posts, params); 
         posts = postLogic.paginateResults(posts, params); 
         return posts.stream().map(DomainPostEntity::toSharedDTO).collect(Collectors.toList()); 
     } 
  
     @Override 
     public SharedPostDTO findPostById(Long id, SharedRequestParams params) { 
         DomainPostEntity post = postRepository.findById(id); 
         return post.toSharedDTO(); 
     } 
  
     @Override 
     public SharedPostDTO findPostBySlug(String slug, SharedRequestParams params) { 
         DomainPostEntity post = postRepository.findBySlug(slug); 
         return post.toSharedDTO(); 
     } 
 } 
 