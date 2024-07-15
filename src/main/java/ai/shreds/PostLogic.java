package ai.shreds.shared; 
  
 import ai.shreds.domain.DomainPostEntity; 
 import ai.shreds.shared.SharedRequestParams; 
 import java.util.List; 
 import java.util.stream.Collectors; 
  
 public class PostLogic { 
  
     public List<DomainPostEntity> applyFilters(List<DomainPostEntity> posts, SharedRequestParams params) { 
         // Apply filters based on the parameters 
         if (params.getAuthor() != null && !params.getAuthor().isEmpty()) { 
             posts = posts.stream() 
                     .filter(post -> params.getAuthor().contains(post.getPost_author())) 
                     .collect(Collectors.toList()); 
         } 
         if (params.getStatus() != null && !params.getStatus().isEmpty()) { 
             posts = posts.stream() 
                     .filter(post -> params.getStatus().contains(post.getPost_status())) 
                     .collect(Collectors.toList()); 
         } 
         // Additional filters can be applied similarly 
         return posts; 
     } 
  
     public List<DomainPostEntity> sortPosts(List<DomainPostEntity> posts, SharedRequestParams params) { 
         // Sort posts based on the order and orderby parameters 
         if ("asc".equalsIgnoreCase(params.getOrder())) { 
             posts.sort((p1, p2) -> comparePosts(p1, p2, params.getOrderby())); 
         } else { 
             posts.sort((p1, p2) -> comparePosts(p2, p1, params.getOrderby())); 
         } 
         return posts; 
     } 
  
     private int comparePosts(DomainPostEntity p1, DomainPostEntity p2, String orderby) { 
         switch (orderby) { 
             case "date": 
                 return p1.getPost_date().compareTo(p2.getPost_date()); 
             case "title": 
                 return p1.getPost_title().compareTo(p2.getPost_title()); 
             // Add more cases for other sorting criteria 
             default: 
                 return 0; 
         } 
     } 
  
     public List<DomainPostEntity> paginateResults(List<DomainPostEntity> posts, SharedRequestParams params) { 
         int offset = params.getOffset() != null ? params.getOffset() : 0; 
         int perPage = params.getPerPage() != null ? params.getPerPage() : 10; 
         return posts.stream() 
                 .skip(offset) 
                 .limit(perPage) 
                 .collect(Collectors.toList()); 
     } 
 } 
 