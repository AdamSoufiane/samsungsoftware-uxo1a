package ai.shreds.domain; 
  
 import lombok.AllArgsConstructor; 
 import lombok.Builder; 
 import lombok.Data; 
 import lombok.NoArgsConstructor; 
  
 import java.time.LocalDateTime; 
 import java.util.Date; 
 import java.util.List; 
 import java.util.Map; 
  
 @Data 
 @Builder 
 @NoArgsConstructor 
 @AllArgsConstructor 
 public class DomainPostEntity { 
     private Long ID; 
     private Long post_author; 
     private LocalDateTime post_date; 
     private LocalDateTime post_date_gmt; 
     private String post_content; 
     private String post_title; 
     private String post_excerpt; 
     private String post_status; 
     private String comment_status; 
     private String ping_status; 
     private String post_password; 
     private String post_name; 
     private String to_ping; 
     private String pinged; 
     private LocalDateTime post_modified; 
     private LocalDateTime post_modified_gmt; 
     private String post_content_filtered; 
     private Long post_parent; 
     private String guid; 
     private Integer menu_order; 
     private String post_type; 
     private String post_mime_type; 
     private Long comment_count; 
  
     public SharedPostDTO toSharedDTO() { 
         return SharedPostDTO.builder() 
                 .ID(this.ID) 
                 .date(Date.from(this.post_date.atZone(ZoneId.systemDefault()).toInstant())) 
                 .guid(this.guid) 
                 .renderedContent(this.post_content) 
                 .modifiedDetails(this.post_modified.toString()) 
                 .slug(this.post_name) 
                 .status(this.post_status) 
                 .type(this.post_type) 
                 .link("link-to-post" + this.ID) 
                 .title(this.post_title) 
                 .content(this.post_content) 
                 .excerpt(this.post_excerpt) 
                 .author(this.post_author) 
                 .featuredMedia(null) // Assuming no featured media field in DomainPostEntity 
                 .commentStatus(this.comment_status) 
                 .pingStatus(this.ping_status) 
                 .sticky(false) // Assuming no sticky field in DomainPostEntity 
                 .template(null) // Assuming no template field in DomainPostEntity 
                 .format(null) // Assuming no format field in DomainPostEntity 
                 .meta(Map.of()) // Assuming no meta field in DomainPostEntity 
                 .categories(List.of()) // Assuming no categories field in DomainPostEntity 
                 .tags(List.of()) // Assuming no tags field in DomainPostEntity 
                 .hyperlinks(Map.of()) // Assuming no hyperlinks field in DomainPostEntity 
                 .build(); 
     } 
 } 
 