package goods.domain.publisher;

import goods.domain.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/***
 * 出版社
 */
@Entity
public class Publisher extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "publisher_id")
    private Long publisherId;

    //name
    @Column(unique = true)
    private String publisherName;
    //地址
    private String address;

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
