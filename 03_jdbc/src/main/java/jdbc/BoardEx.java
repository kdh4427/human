package jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardEx {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc.xml");
		
		BoardService service = ctx.getBean("boardService", BoardService.class);
		System.out.println(service.getTime());
		// 글 작성
		Board board = new Board();
		board.setTitle("스프링에서 작성한 제목");
		board.setContent("내용내용");
		service.write(board);
		
		// 글 수정
		Board board2 = new Board();
		board.setBno(114864L);
		board.setTitle("스프링에서 수정된 제목");
		service.modify(board2);
		
		// 글 목록 조회
//		List<Map<String, Object>> obj = service.getList();
//		System.out.println(obj);
//		for(Map<String, Object> map : obj) {
//			System.out.println(map.get("BNO") + "::" + map.get("TITLE"));
//		}
		
		service.getListBoard().forEach(System.out::println);
		
		// 단일 조회
		System.out.println("================================");
		
		
		ctx.close();
		
		
	}
}
