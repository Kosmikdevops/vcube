package com.VCubeDataManagment.Dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.VCubeDataManagment.Entity.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionForm {

	private List<Question> questions;

}
