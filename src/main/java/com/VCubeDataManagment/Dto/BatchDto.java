package com.VCubeDataManagment.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {

    private String Batchname;
    private Date Startingdate;
    private String coursename;
}
