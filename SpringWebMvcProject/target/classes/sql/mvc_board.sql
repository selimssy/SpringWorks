-- 게시판 테이블 생성
CREATE TABLE mvc_board (
	board_no INT PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	content TEXT NULL,
	writer VARCHAR(50) NOT NULL,
	reg_date TIMESTAMP DEFAULT NOW(),
	view_cnt INT DEFAULT 0
);


-- 썸네일이미지 경로 컬럼 추가
ALTER TABLE mvc_board ADD COLUMN thumb_img VARCHAR(1000);