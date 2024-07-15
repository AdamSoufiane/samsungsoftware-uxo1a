package ai.shreds.adapter; 
  
 import ai.shreds.shared.SharedPostDTO; 
 import ai.shreds.shared.SharedRequestParams; 
 import ai.shreds.application.ApplicationPostPort; 
 import org.springframework.web.bind.annotation.GetMapping; 
 import org.springframework.web.bind.annotation.PathVariable; 
 import org.springframework.web.bind.annotation.RequestMapping; 
 import org.springframework.web.bind.annotation.RequestParam; 
 import org.springframework.web.bind.annotation.RestController; 
 import java.util.List; 
  
 @RestController 
 @RequestMapping("/wp-json/wp/v2/posts") 
 public class AdapterPostController { 
  
     private final ApplicationPostPort applicationPostPort; 
  
     public AdapterPostController(ApplicationPostPort applicationPostPort) { 
         this.applicationPostPort = applicationPostPort; 
     } 
  
     @GetMapping 
     public List<SharedPostDTO> getAllPosts(SharedRequestParams params) { 
         return applicationPostPort.findAllPosts(params); 
     } 
  
     @GetMapping("/{id}") 
     public SharedPostDTO getPostById(@PathVariable Long id, @RequestParam SharedRequestParams params) { 
         return applicationPostPort.findPostById(id, params); 
     } 
  
     @GetMapping(params = "slug") 
     public SharedPostDTO getPostBySlug(@RequestParam String slug, @RequestParam SharedRequestParams params) { 
         return applicationPostPort.findPostBySlug(slug, params); 
     } 
 } 
 