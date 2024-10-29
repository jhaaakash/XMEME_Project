package com.crio.starter.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "memes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meme {
    @Id
    private String id;
    private String name;
    private String caption;
    private String url;
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();
}
