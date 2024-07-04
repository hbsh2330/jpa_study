package com.example.jpa_study.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "write_tbl")
public class Write {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
//    name = "user_id" 테이블 컬럼명 왜리키를 걸겠다 왜래키 이름은 fk_write_Tbl_user_id
    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name="fk_write_Tbl_user_id", foreignKeyDefinition = "FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE ON UPDATE CASCADE"))
    private User user; //테이블에서 user_id로 저장
    private String content;
    private LocalDateTime regDate;
}
