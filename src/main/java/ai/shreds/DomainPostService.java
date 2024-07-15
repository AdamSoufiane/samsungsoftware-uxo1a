package ai.shreds.domain; 
  
 import ai.shreds.shared.SharedRequestParams; 
 import ai.shreds.shared.SharedPostDTO; 
 import java.util.List; 
 import java.util.stream.Collectors; 
  
 public class DomainPostService { 
  
     private final DomainPostRepositoryPort postRepositoryPort; 
  
     public DomainPostService(DomainPostRepositoryPort postRepositoryPort) { 
         this.postRepositoryPort = postRepositoryPort; 
     } 
  
     public List<DomainPostEntity> applyFilters(List<DomainPostEntity> posts, SharedRequestParams params) { 
         // Apply filters based on the parameters provided 
         return posts.stream() 
                 .filter(post -> (params.getAuthor() == null || params.getAuthor().contains(post.getPost_author()))) 
                 .filter(post -> (params.getStatus() == null || params.getStatus().contains(post.getPost_status()))) 
                 .filter(post -> (params.getCategories() == null || params.getCategories().contains(post.getPost_parent()))) 
                 .collect(Collectors.toList()); 
     } 
  
     public List<DomainPostEntity> sortPosts(List<DomainPostEntity> posts, SharedRequestParams params) { 
         // Sort posts based on the requested order 
         if ("date".equals(params.getOrderby())) { 
             posts.sort((p1, p2) -> p1.getPost_date().compareTo(p2.getPost_date())); 
         } else if ("title".equals(params.getOrderby())) { 
             posts.sort((p1, p2) -> p1.getPost_title().compareTo(p2.getPost_title())); 
         } 
         if ("desc".equals(params.getOrder())) { 
             posts.sort((p1, p2) -> -1); 
         } 
         return posts; 
     } 
  
     public List<DomainPostEntity> paginateResults(List<DomainPostEntity> posts, SharedRequestParams params) { 
         // Implement pagination logic 
         int offset = params.getOffset() != null ? params.getOffset() : 0; 
         int perPage = params.getPerPage() != null ? params.getPerPage() : 10; 
         return posts.stream().skip(offset).limit(perPage).collect(Collectors.toList()); 
     } 
 } 
 