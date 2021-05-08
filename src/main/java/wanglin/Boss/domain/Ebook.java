package wanglin.Boss.domain;

public class Ebook {
    private Long id;

    private String name;

    private Long category1Id;

    private Long category2Id;

    private String description;

    private String cover;

    private Integer docCont;

    private Integer viewCont;

    private Integer voteCont;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDocCont() {
        return docCont;
    }

    public void setDocCont(Integer docCont) {
        this.docCont = docCont;
    }

    public Integer getViewCont() {
        return viewCont;
    }

    public void setViewCont(Integer viewCont) {
        this.viewCont = viewCont;
    }

    public Integer getVoteCont() {
        return voteCont;
    }

    public void setVoteCont(Integer voteCont) {
        this.voteCont = voteCont;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", category1Id=").append(category1Id);
        sb.append(", category2Id=").append(category2Id);
        sb.append(", description=").append(description);
        sb.append(", cover=").append(cover);
        sb.append(", docCont=").append(docCont);
        sb.append(", viewCont=").append(viewCont);
        sb.append(", voteCont=").append(voteCont);
        sb.append("]");
        return sb.toString();
    }
}