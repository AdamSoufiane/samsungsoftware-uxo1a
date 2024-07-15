package ai.shreds.application; 
  
 import ai.shreds.shared.SharedPostDTO; 
 import ai.shreds.shared.SharedRequestParams; 
 import java.util.List; 
  
 public interface ApplicationPostPort { 
     List<SharedPostDTO> findAllPosts(SharedRequestParams params); 
     SharedPostDTO findPostById(Long id, SharedRequestParams params); 
     SharedPostDTO findPostBySlug(String slug, SharedRequestParams params); 
 } 
 