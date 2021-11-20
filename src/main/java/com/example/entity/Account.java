package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "account")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Account implements Serializable {

    /**
     * アカウントNumber
     */
    @Id
    @Column(name = "account_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    /**
     * Emailアドレス
     */
    @Column(name="email_address")
    private String emailAddress;

    /**
     * ニックネーム
     */
    @Column(name="nick_name")
    private String nickName;

    @JsonIgnore
    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @JsonIgnore
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Column(name = "updated_by")
    private String updatedBy;

}
