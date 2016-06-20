create table EDCON_Board (
	boardSeq LONG not null primary key,
	title STRING null,
	content STRING null,
	groupId LONG,
	customId VARCHAR(75) null,
	writerId LONG,
	writerDate DATE null,
	readCnt INTEGER,
	groupBoardSeq INTEGER,
	groupBoardTurn INTEGER,
	replyDepth INTEGER,
	siteGroup VARCHAR(75) null,
	popupYn BOOLEAN,
	popupStartDt DATE null,
	popupEndDt DATE null,
	insertId LONG,
	insertDt DATE null,
	updateId LONG,
	updateDt DATE null
);

create table EDCON_BoardDiv (
	divCd LONG not null primary key,
	titleNm STRING null,
	ContentNm STRING null,
	divNm VARCHAR(75) null,
	fileUpLoadUseYn BOOLEAN,
	popupYn BOOLEAN,
	replyYn BOOLEAN
);

create table EDCON_BoardDiv_Board (
	boardSeq LONG not null,
	divCd LONG not null,
	primary key (boardSeq, divCd)
);