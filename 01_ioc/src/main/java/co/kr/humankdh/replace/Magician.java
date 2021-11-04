package co.kr.humankdh.replace;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.experimental.Wither;

@Setter
public class Magician {
	private String magicWord;
	private MagicBox magicBox;
	@Autowired
	void magic() {
		System.out.println("상자안에는 무엇이 있을까요?");
		System.out.println("주문 : " + magicWord);
		System.out.println("내용물 : " + magicBox.getContent());
	}
}
