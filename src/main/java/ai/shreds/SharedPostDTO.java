package ai.shreds.shared; 
  
 import lombok.AllArgsConstructor; 
 import lombok.Builder; 
 import lombok.Data; 
 import lombok.NoArgsConstructor; 
  
 import java.util.Date; 
 import java.util.List; 
 import java.util.Map; 
  
 @Data 
 @Builder 
 @NoArgsConstructor 
 @AllArgsConstructor 
 public class SharedPostDTO { 
     private Long ID; 
     private Date date; 
     private String guid; 
     private String renderedContent; 
     private String modifiedDetails; 
     private String slug; 
     private String status; 
     private String type; 
     private String link; 
     private String title; 
     private String content; 
     private String excerpt; 
     private Long author; 
     private Long featuredMedia; 
     private String commentStatus; 
     private String pingStatus; 
     private Boolean sticky; 
     private String template; 
     private String format; 
     private Map<String, Object> meta; 
     private List<Long> categories; 
     private List<Long> tags; 
     private Map<String, String> hyperlinks; 
  
     public DomainPostEntity toDomainEntity() { 
         return DomainPostEntity.builder() 
                 .ID(this.ID) 
                 .post_author(this.author) 
                 .post_date(this.date) 
                 .post_content(this.content) 
                 .post_title(this.title) 
                 .post_excerpt(this.excerpt) 
                 .post_status(this.status) 
                 .comment_status(this.commentStatus) 
                 .ping_status(this.pingStatus) 
                 .post_password(null)  // Not exposed in DTO 
                 .post_name(this.slug) 
                 .to_ping(null)  // Not exposed in DTO 
                 .pinged(null)  // Not exposed in DTO 
                 .post_modified(null)  // Not exposed in DTO 
                 .post_modified_gmt(null)  // Not exposed in DTO 
                 .post_content_filtered(null)  // Not exposed in DTO 
                 .post_parent(null)  // Not exposed in DTO 
                 .guid(this.guid) 
                 .menu_order(null)  // Not exposed in DTO 
                 .post_type(this.type) 
                 .post_mime_type(null)  // Not exposed in DTO 
                 .comment_count(null)  // Not exposed in DTO 
                 .build(); 
     } 
 } 
 