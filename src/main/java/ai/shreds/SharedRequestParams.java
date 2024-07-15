package ai.shreds.shared; 
  
 import lombok.Data; 
 import java.util.Date; 
 import java.util.List; 
  
 @Data 
 public class SharedRequestParams { 
     private String context; 
     private Integer page; 
     private Integer perPage; 
     private String search; 
     private Date after; 
     private Date modifiedAfter; 
     private List<Long> author; 
     private List<Long> authorExclude; 
     private Date before; 
     private Date modifiedBefore; 
     private List<Long> exclude; 
     private List<Long> include; 
     private Integer offset; 
     private String order; 
     private String orderby; 
     private String slug; 
     private List<String> status; 
     private List<Long> categories; 
     private List<Long> categoriesExclude; 
     private List<Long> tags; 
     private List<Long> tagsExclude; 
     private Boolean sticky; 
  
     public SharedRequestParams() {} 
  
     public SharedRequestParams(String context, Integer page, Integer perPage, String search, Date after, Date modifiedAfter, List<Long> author, List<Long> authorExclude, Date before, Date modifiedBefore, List<Long> exclude, List<Long> include, Integer offset, String order, String orderby, String slug, List<String> status, List<Long> categories, List<Long> categoriesExclude, List<Long> tags, List<Long> tagsExclude, Boolean sticky) { 
         this.context = context; 
         this.page = page; 
         this.perPage = perPage; 
         this.search = search; 
         this.after = after; 
         this.modifiedAfter = modifiedAfter; 
         this.author = author; 
         this.authorExclude = authorExclude; 
         this.before = before; 
         this.modifiedBefore = modifiedBefore; 
         this.exclude = exclude; 
         this.include = include; 
         this.offset = offset; 
         this.order = order; 
         this.orderby = orderby; 
         this.slug = slug; 
         this.status = status; 
         this.categories = categories; 
         this.categoriesExclude = categoriesExclude; 
         this.tags = tags; 
         this.tagsExclude = tagsExclude; 
         this.sticky = sticky; 
     } 
  
     public String getContext() { 
         return context; 
     } 
  
     public void setContext(String context) { 
         this.context = context; 
     } 
  
     public Integer getPage() { 
         return page; 
     } 
  
     public void setPage(Integer page) { 
         this.page = page; 
     } 
  
     public Integer getPerPage() { 
         return perPage; 
     } 
  
     public void setPerPage(Integer perPage) { 
         this.perPage = perPage; 
     } 
  
     public String getSearch() { 
         return search; 
     } 
  
     public void setSearch(String search) { 
         this.search = search; 
     } 
  
     public Date getAfter() { 
         return after; 
     } 
  
     public void setAfter(Date after) { 
         this.after = after; 
     } 
  
     public Date getModifiedAfter() { 
         return modifiedAfter; 
     } 
  
     public void setModifiedAfter(Date modifiedAfter) { 
         this.modifiedAfter = modifiedAfter; 
     } 
  
     public List<Long> getAuthor() { 
         return author; 
     } 
  
     public void setAuthor(List<Long> author) { 
         this.author = author; 
     } 
  
     public List<Long> getAuthorExclude() { 
         return authorExclude; 
     } 
  
     public void setAuthorExclude(List<Long> authorExclude) { 
         this.authorExclude = authorExclude; 
     } 
  
     public Date getBefore() { 
         return before; 
     } 
  
     public void setBefore(Date before) { 
         this.before = before; 
     } 
  
     public Date getModifiedBefore() { 
         return modifiedBefore; 
     } 
  
     public void setModifiedBefore(Date modifiedBefore) { 
         this.modifiedBefore = modifiedBefore; 
     } 
  
     public List<Long> getExclude() { 
         return exclude; 
     } 
  
     public void setExclude(List<Long> exclude) { 
         this.exclude = exclude; 
     } 
  
     public List<Long> getInclude() { 
         return include; 
     } 
  
     public void setInclude(List<Long> include) { 
         this.include = include; 
     } 
  
     public Integer getOffset() { 
         return offset; 
     } 
  
     public void setOffset(Integer offset) { 
         this.offset = offset; 
     } 
  
     public String getOrder() { 
         return order; 
     } 
  
     public void setOrder(String order) { 
         this.order = order; 
     } 
  
     public String getOrderby() { 
         return orderby; 
     } 
  
     public void setOrderby(String orderby) { 
         this.orderby = orderby; 
     } 
  
     public String getSlug() { 
         return slug; 
     } 
  
     public void setSlug(String slug) { 
         this.slug = slug; 
     } 
  
     public List<String> getStatus() { 
         return status; 
     } 
  
     public void setStatus(List<String> status) { 
         this.status = status; 
     } 
  
     public List<Long> getCategories() { 
         return categories; 
     } 
  
     public void setCategories(List<Long> categories) { 
         this.categories = categories; 
     } 
  
     public List<Long> getCategoriesExclude() { 
         return categoriesExclude; 
     } 
  
     public void setCategoriesExclude(List<Long> categoriesExclude) { 
         this.categoriesExclude = categoriesExclude; 
     } 
  
     public List<Long> getTags() { 
         return tags; 
     } 
  
     public void setTags(List<Long> tags) { 
         this.tags = tags; 
     } 
  
     public List<Long> getTagsExclude() { 
         return tagsExclude; 
     } 
  
     public void setTagsExclude(List<Long> tagsExclude) { 
         this.tagsExclude = tagsExclude; 
     } 
  
     public Boolean getSticky() { 
         return sticky; 
     } 
  
     public void setSticky(Boolean sticky) { 
         this.sticky = sticky; 
     } 
 } 
 