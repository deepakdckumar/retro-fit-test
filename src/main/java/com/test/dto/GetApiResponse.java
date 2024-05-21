package com.test.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetApiResponse {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Datum> data;
    private Support support;

    @Data
    public static class Datum {
        private int id;
        private String email;
        private String first_name;
        private String last_name;
        private String avatar;
    }

    @Data
    public static class Support {
        private String url;
        private String text;
    }
}
