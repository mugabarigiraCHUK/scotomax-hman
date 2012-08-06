--------------------------------------------------------
--  File created - Monday-August-06-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CBS_COURSE
--------------------------------------------------------

  CREATE TABLE "CBS_COURSE" 
   (	"CBS_ID" NUMBER, 
	"COURSE_ID" NUMBER
   ) ;
/
--------------------------------------------------------
--  DDL for Table CBS_DEPARTMENTS
--------------------------------------------------------

  CREATE TABLE "CBS_DEPARTMENTS" 
   (	"CBS_ID" NUMBER, 
	"CBS_DEPARTMENT" VARCHAR2(200 BYTE)
   ) ;
/
--------------------------------------------------------
--  DDL for Table CBS_PREFERED
--------------------------------------------------------

  CREATE TABLE "CBS_PREFERED" 
   (	"ID_CODE" NUMBER(13,0), 
	"CBS_ID" NUMBER
   ) ;
/
--------------------------------------------------------
--  DDL for Table CLASS
--------------------------------------------------------

  CREATE TABLE "CLASS" 
   (	"CLASSROOM_ID" NUMBER, 
	"COURSE_ID" NUMBER
   ) ;
/
--------------------------------------------------------
--  DDL for Table CLASSROOM
--------------------------------------------------------

  CREATE TABLE "CLASSROOM" 
   (	"CLASSROOM_ID" NUMBER, 
	"ROOM_NO" VARCHAR2(50 BYTE), 
	"MAX_SEAT" NUMBER(2,0), 
	"LEFT_SEAT" NUMBER(2,0)
   ) ;
/
--------------------------------------------------------
--  DDL for Table COURSE
--------------------------------------------------------

  CREATE TABLE "COURSE" 
   (	"COURSE_ID" NUMBER, 
	"COURSE_NAME" VARCHAR2(200 BYTE), 
	"COURSE_FEE" NUMBER(4,0) DEFAULT 0, 
	"COURSE_START" DATE DEFAULT SYSDATE, 
	"COURSE_END" DATE
   ) ;
 

   COMMENT ON COLUMN "COURSE"."COURSE_START" IS 'SYSDATE';
/
--------------------------------------------------------
--  DDL for Table COURSE_SCHEDULE
--------------------------------------------------------

  CREATE TABLE "COURSE_SCHEDULE" 
   (	"COURSE_ID" NUMBER, 
	"DAY" NUMBER, 
	"BEGIN_TIME" DATE, 
	"END_TIME" DATE, 
	"HOURS" NUMBER(2,1), 
	"SCHEDULE_ID" NUMBER
   ) ;
/
--------------------------------------------------------
--  DDL for Table COURSE_TRAINER
--------------------------------------------------------

  CREATE TABLE "COURSE_TRAINER" 
   (	"COURSE_ID" NUMBER(13,0), 
	"TRAINER_ID" NUMBER(13,0)
   ) ;
/
--------------------------------------------------------
--  DDL for Table DEPARTMENT
--------------------------------------------------------

  CREATE TABLE "DEPARTMENT" 
   (	"DEP_ID" NUMBER, 
	"DEPARTMENT_NAME" VARCHAR2(200 BYTE)
   ) ;
/
--------------------------------------------------------
--  DDL for Table EXAM
--------------------------------------------------------

  CREATE TABLE "EXAM" 
   (	"EXAM_NO" NUMBER(13,0), 
	"ITEM" NUMBER(13,0), 
	"QUESTION" VARCHAR2(200 BYTE), 
	"ANS1" VARCHAR2(200 BYTE), 
	"ANS2" VARCHAR2(200 BYTE), 
	"ANS3" VARCHAR2(200 BYTE), 
	"ANS4" VARCHAR2(200 BYTE), 
	"ANS" NUMBER(2,0)
   ) ;
/
--------------------------------------------------------
--  DDL for Table EXAM_SERIES
--------------------------------------------------------

  CREATE TABLE "EXAM_SERIES" 
   (	"COURSE_ID" NUMBER(13,0), 
	"EXAM_NO" NUMBER(6,0), 
	"EXAM_DESCRIPTION" VARCHAR2(200 BYTE), 
	"FULL_SCORE" NUMBER(6,0)
   ) ;
/
--------------------------------------------------------
--  DDL for Table STD_PROFILE
--------------------------------------------------------

  CREATE TABLE "STD_PROFILE" 
   (	"ID_CODE" NUMBER(13,0), 
	"FIRSTNAME" VARCHAR2(200 BYTE), 
	"LASTNAME" VARCHAR2(200 BYTE), 
	"PIC_CONTENT" BLOB, 
	"TITLE" VARCHAR2(50 BYTE), 
	"BIRTHDATE" DATE, 
	"ADDRESS" VARCHAR2(500 BYTE), 
	"PROVINCE" VARCHAR2(200 BYTE), 
	"PHONE_NO" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"INSTITUTE_NAME" VARCHAR2(200 BYTE), 
	"EDU_LEVEL" VARCHAR2(200 BYTE), 
	"GPA" NUMBER(3,2), 
	"REGISTERED_DATE" DATE DEFAULT sysdate, 
	"ID_NUMBER" VARCHAR2(100 BYTE), 
	"PIC_NAME" VARCHAR2(200 BYTE), 
	"PIC_SIZE" NUMBER(7,0), 
	"PIC_TYPE" VARCHAR2(200 BYTE)
   ) ;
/
--------------------------------------------------------
--  DDL for Table TAKE_EXAM
--------------------------------------------------------

  CREATE TABLE "TAKE_EXAM" 
   (	"ID_CODE" NUMBER(13,0), 
	"ITEM" NUMBER, 
	"ANS" NUMBER, 
	"TEST_DATE" DATE DEFAULT sysdate
   ) ;
/
--------------------------------------------------------
--  DDL for Table TRAINEE_GRADE
--------------------------------------------------------

  CREATE TABLE "TRAINEE_GRADE" 
   (	"ID_CODE" NUMBER(13,0), 
	"COURSE_ID" NUMBER, 
	"EXAM_NO" NUMBER, 
	"PRETEST_SCORE" NUMBER(3,0), 
	"POSTTEST_SCORE" NUMBER(3,0)
   ) ;
/
--------------------------------------------------------
--  DDL for Table TRAINER_PROFILE
--------------------------------------------------------

  CREATE TABLE "TRAINER_PROFILE" 
   (	"TRAINER_ID" NUMBER(13,0), 
	"FIRSTNAME" VARCHAR2(200 BYTE), 
	"LASTNAME" VARCHAR2(200 BYTE), 
	"PIC_CONTENT" BLOB, 
	"GENDER" VARCHAR2(50 BYTE), 
	"PHONE_NO" NUMBER(10,0), 
	"EMAIL" VARCHAR2(200 BYTE), 
	"DEGREE" VARCHAR2(100 BYTE), 
	"PROGRAM" VARCHAR2(100 BYTE), 
	"UNIVERSITY" VARCHAR2(100 BYTE), 
	"DEP_ID" NUMBER(9,0), 
	"PIC_NAME" VARCHAR2(200 BYTE), 
	"PIC_SIZE" NUMBER(7,0), 
	"PIC_TYPE" VARCHAR2(100 BYTE)
   ) ;
/
--------------------------------------------------------
--  DDL for Table USER_LOGIN
--------------------------------------------------------

  CREATE TABLE "USER_LOGIN" 
   (	"ID_CODE" NUMBER(13,0), 
	"USERNAME" VARCHAR2(8 BYTE), 
	"PASSWD" VARCHAR2(8 BYTE), 
	"LAST_LOGIN" DATE DEFAULT sysdate
   ) ;
/
REM INSERTING into CBS_COURSE
SET DEFINE OFF;
Insert into CBS_COURSE (CBS_ID,COURSE_ID) values (101,100);
Insert into CBS_COURSE (CBS_ID,COURSE_ID) values (102,100);
REM INSERTING into CBS_DEPARTMENTS
SET DEFINE OFF;
Insert into CBS_DEPARTMENTS (CBS_ID,CBS_DEPARTMENT) values (100,'การเงินการบัญชี');
Insert into CBS_DEPARTMENTS (CBS_ID,CBS_DEPARTMENT) values (101,'สถิติประยุกต์');
Insert into CBS_DEPARTMENTS (CBS_ID,CBS_DEPARTMENT) values (102,'คณิตศาสตร์สถิติ');
Insert into CBS_DEPARTMENTS (CBS_ID,CBS_DEPARTMENT) values (103,'การจัดการเบื้องต้น');
REM INSERTING into CBS_PREFERED
SET DEFINE OFF;
REM INSERTING into CLASS
SET DEFINE OFF;
Insert into CLASS (CLASSROOM_ID,COURSE_ID) values (11,100);
Insert into CLASS (CLASSROOM_ID,COURSE_ID) values (22,100);
Insert into CLASS (CLASSROOM_ID,COURSE_ID) values (22,101);
Insert into CLASS (CLASSROOM_ID,COURSE_ID) values (33,101);
REM INSERTING into CLASSROOM
SET DEFINE OFF;
Insert into CLASSROOM (CLASSROOM_ID,ROOM_NO,MAX_SEAT,LEFT_SEAT) values (11,'ก1111',20,20);
Insert into CLASSROOM (CLASSROOM_ID,ROOM_NO,MAX_SEAT,LEFT_SEAT) values (44,'ง4444',20,20);
Insert into CLASSROOM (CLASSROOM_ID,ROOM_NO,MAX_SEAT,LEFT_SEAT) values (22,'ข2222',20,20);
Insert into CLASSROOM (CLASSROOM_ID,ROOM_NO,MAX_SEAT,LEFT_SEAT) values (33,'ค3333',20,20);
REM INSERTING into COURSE
SET DEFINE OFF;
Insert into COURSE (COURSE_ID,COURSE_NAME,COURSE_FEE,COURSE_START,COURSE_END) values (100,'วิทยาศาสตร์',450,to_date('13-AUG-12','DD-MON-RR'),to_date('17-AUG-12','DD-MON-RR'));
Insert into COURSE (COURSE_ID,COURSE_NAME,COURSE_FEE,COURSE_START,COURSE_END) values (101,'คณิตศาสตร์',500,to_date('06-AUG-12','DD-MON-RR'),to_date('10-AUG-12','DD-MON-RR'));
REM INSERTING into COURSE_SCHEDULE
SET DEFINE OFF;
Insert into COURSE_SCHEDULE (COURSE_ID,DAY,BEGIN_TIME,END_TIME,HOURS,SCHEDULE_ID) values (101,null,to_date('07-AUG-12','DD-MON-RR'),to_date('07-AUG-12','DD-MON-RR'),3,1344232909);
Insert into COURSE_SCHEDULE (COURSE_ID,DAY,BEGIN_TIME,END_TIME,HOURS,SCHEDULE_ID) values (100,null,to_date('14-AUG-12','DD-MON-RR'),to_date('14-AUG-12','DD-MON-RR'),2,1344231693);
Insert into COURSE_SCHEDULE (COURSE_ID,DAY,BEGIN_TIME,END_TIME,HOURS,SCHEDULE_ID) values (101,null,to_date('06-AUG-12','DD-MON-RR'),to_date('06-AUG-12','DD-MON-RR'),2,1344232897);
REM INSERTING into COURSE_TRAINER
SET DEFINE OFF;
Insert into COURSE_TRAINER (COURSE_ID,TRAINER_ID) values (100,1343988713);
Insert into COURSE_TRAINER (COURSE_ID,TRAINER_ID) values (100,1344229469);
Insert into COURSE_TRAINER (COURSE_ID,TRAINER_ID) values (101,1343988713);
REM INSERTING into DEPARTMENT
SET DEFINE OFF;
Insert into DEPARTMENT (DEP_ID,DEPARTMENT_NAME) values (105,'ควอนตัมฟิสิกต์');
Insert into DEPARTMENT (DEP_ID,DEPARTMENT_NAME) values (101,'วิทยาศาสตร์');
Insert into DEPARTMENT (DEP_ID,DEPARTMENT_NAME) values (100,'คณิตศาสตร์');
Insert into DEPARTMENT (DEP_ID,DEPARTMENT_NAME) values (102,'ชีววิทยา');
Insert into DEPARTMENT (DEP_ID,DEPARTMENT_NAME) values (103,'ตรรกศาสตร์');
Insert into DEPARTMENT (DEP_ID,DEPARTMENT_NAME) values (104,'แคลคูลัสเบื้องต้น');
REM INSERTING into EXAM
SET DEFINE OFF;
Insert into EXAM (EXAM_NO,ITEM,QUESTION,ANS1,ANS2,ANS3,ANS4,ANS) values (112,2,'มานีเป็นเพื่อนกับใคร','มานา','มานะ','มาช้า','มายังไง',2);
Insert into EXAM (EXAM_NO,ITEM,QUESTION,ANS1,ANS2,ANS3,ANS4,ANS) values (112,3,'เราควรจะฝากเงินไว้ที่ไหน','พ่อ','แม่','ธนาคาร','ฝังดิน',3);
REM INSERTING into EXAM_SERIES
SET DEFINE OFF;
Insert into EXAM_SERIES (COURSE_ID,EXAM_NO,EXAM_DESCRIPTION,FULL_SCORE) values (100,111,'เป็นวิชาที่เปิดสอนเกี่ยวกับความรู้เบื้องต้นของวิทยาศาสตร์',20);
Insert into EXAM_SERIES (COURSE_ID,EXAM_NO,EXAM_DESCRIPTION,FULL_SCORE) values (101,112,'ทดสอบเพื่อวัดผลความรู้ความเข้าใจของนักเรียน',25);
REM INSERTING into STD_PROFILE
SET DEFINE OFF;
Insert into STD_PROFILE (ID_CODE,FIRSTNAME,LASTNAME,TITLE,BIRTHDATE,ADDRESS,PROVINCE,PHONE_NO,EMAIL,INSTITUTE_NAME,EDU_LEVEL,GPA,REGISTERED_DATE,ID_NUMBER,PIC_NAME,PIC_SIZE,PIC_TYPE) values (1343647827,'ศรายุทธ','อุตสาคู','นาย',to_date('04-APR-82','DD-MON-RR'),'11 แขวงจันทรเกษม เขตจัตุจักร','กรุงเทพฯ','66813933471','developmax@gmail.com','โรงเรียนวัดประชานิมิตร','มัธยมปลาย',2.83,to_date('30-JUL-12','DD-MON-RR'),'12345678900',null,null,null);
REM INSERTING into TAKE_EXAM
SET DEFINE OFF;
REM INSERTING into TRAINEE_GRADE
SET DEFINE OFF;
REM INSERTING into TRAINER_PROFILE
SET DEFINE OFF;
Insert into TRAINER_PROFILE (TRAINER_ID,FIRSTNAME,LASTNAME,GENDER,PHONE_NO,EMAIL,DEGREE,PROGRAM,UNIVERSITY,DEP_ID,PIC_NAME,PIC_SIZE,PIC_TYPE) values (1343988713,'นวิน','มีรัก','ชาย',819999999,'nawin@hotmail.com','ปริญญาโท','การจัดการ','สุโขทัยธรรมาธิราศ',101,null,null,null);
Insert into TRAINER_PROFILE (TRAINER_ID,FIRSTNAME,LASTNAME,GENDER,PHONE_NO,EMAIL,DEGREE,PROGRAM,UNIVERSITY,DEP_ID,PIC_NAME,PIC_SIZE,PIC_TYPE) values (1343989105,'ภิสมัย','อารมณ์ดี','หญิง',812342345,'phisamai@hotmail.com','ปริญญาโท','วิทยาศาสตร์การบัญชี','จุฬาฯ',101,null,null,null);
Insert into TRAINER_PROFILE (TRAINER_ID,FIRSTNAME,LASTNAME,GENDER,PHONE_NO,EMAIL,DEGREE,PROGRAM,UNIVERSITY,DEP_ID,PIC_NAME,PIC_SIZE,PIC_TYPE) values (1344229469,'ณเดช','คุคิมิยะ','ชาย',823333333,'ืnades@hotmail.com','ปริญญาโท','คณิตศาสตร์ประยุกต์','มหาวิทยาลัยรามคำแหง',100,null,null,null);
REM INSERTING into USER_LOGIN
SET DEFINE OFF;
Insert into USER_LOGIN (ID_CODE,USERNAME,PASSWD,LAST_LOGIN) values (1211111111111,'Malipen','1234',to_date('14-JUL-12','DD-MON-RR'));
Insert into USER_LOGIN (ID_CODE,USERNAME,PASSWD,LAST_LOGIN) values (1343647827,'sarayut','1234',to_date('03-AUG-12','DD-MON-RR'));
--------------------------------------------------------
--  DDL for Index CBS_DEP_IDX
--------------------------------------------------------

  CREATE INDEX "CBS_DEP_IDX" ON "CBS_DEPARTMENTS" ("CBS_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index CLASSROOM_IDX
--------------------------------------------------------

  CREATE INDEX "CLASSROOM_IDX" ON "CLASSROOM" ("CLASSROOM_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index COURSE_IDX
--------------------------------------------------------

  CREATE INDEX "COURSE_IDX" ON "COURSE" ("COURSE_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index COURSE_SCHD_IDX
--------------------------------------------------------

  CREATE INDEX "COURSE_SCHD_IDX" ON "COURSE_SCHEDULE" ("COURSE_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index DEPARTMENT_IDX
--------------------------------------------------------

  CREATE INDEX "DEPARTMENT_IDX" ON "DEPARTMENT" ("DEP_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index EXAM_IDX
--------------------------------------------------------

  CREATE INDEX "EXAM_IDX" ON "EXAM" ("EXAM_NO", "ITEM") 
  ;
/
--------------------------------------------------------
--  DDL for Index EXAM_SERIES_IDX
--------------------------------------------------------

  CREATE INDEX "EXAM_SERIES_IDX" ON "EXAM_SERIES" ("COURSE_ID", "EXAM_NO") 
  ;
/
--------------------------------------------------------
--  DDL for Index LOGIN_IDX
--------------------------------------------------------

  CREATE INDEX "LOGIN_IDX" ON "USER_LOGIN" ("ID_CODE", "USERNAME") 
  ;
/
--------------------------------------------------------
--  DDL for Index STD_IDX
--------------------------------------------------------

  CREATE INDEX "STD_IDX" ON "STD_PROFILE" ("ID_CODE") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010820
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010820" ON "CBS_PREFERED" ("ID_CODE", "CBS_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010832
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010832" ON "TRAINER_PROFILE" ("TRAINER_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010840
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010840" ON "CBS_COURSE" ("CBS_ID", "COURSE_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010855
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010855" ON "CLASS" ("CLASSROOM_ID", "COURSE_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010862
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010862" ON "COURSE_TRAINER" ("COURSE_ID", "TRAINER_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010885
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010885" ON "TRAINEE_GRADE" ("ID_CODE", "COURSE_ID", "EXAM_NO") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010896
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010896" ON "COURSE_SCHEDULE" ("SCHEDULE_ID") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010905
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010905" ON "EXAM_SERIES" ("EXAM_NO") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010907
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010907" ON "EXAM" ("ITEM") 
  ;
/
--------------------------------------------------------
--  DDL for Index SYS_C0010909
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYS_C0010909" ON "TAKE_EXAM" ("ID_CODE", "ITEM") 
  ;
/
--------------------------------------------------------
--  DDL for Index UNQ_ID_NUMBER
--------------------------------------------------------

  CREATE UNIQUE INDEX "UNQ_ID_NUMBER" ON "STD_PROFILE" ("ID_NUMBER") 
  ;
/
--------------------------------------------------------
--  DDL for Index UNQ_USERNAME
--------------------------------------------------------

  CREATE UNIQUE INDEX "UNQ_USERNAME" ON "USER_LOGIN" ("USERNAME") 
  ;
/
--------------------------------------------------------
--  Constraints for Table CBS_COURSE
--------------------------------------------------------

  ALTER TABLE "CBS_COURSE" MODIFY ("CBS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CBS_COURSE" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CBS_COURSE" ADD PRIMARY KEY ("CBS_ID", "COURSE_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CBS_DEPARTMENTS
--------------------------------------------------------

  ALTER TABLE "CBS_DEPARTMENTS" MODIFY ("CBS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CBS_DEPARTMENTS" MODIFY ("CBS_DEPARTMENT" NOT NULL ENABLE);
 
  ALTER TABLE "CBS_DEPARTMENTS" ADD PRIMARY KEY ("CBS_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CBS_PREFERED
--------------------------------------------------------

  ALTER TABLE "CBS_PREFERED" MODIFY ("ID_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "CBS_PREFERED" MODIFY ("CBS_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CBS_PREFERED" ADD PRIMARY KEY ("ID_CODE", "CBS_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CLASS
--------------------------------------------------------

  ALTER TABLE "CLASS" MODIFY ("CLASSROOM_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CLASS" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CLASS" ADD PRIMARY KEY ("CLASSROOM_ID", "COURSE_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table CLASSROOM
--------------------------------------------------------

  ALTER TABLE "CLASSROOM" MODIFY ("CLASSROOM_ID" NOT NULL ENABLE);
 
  ALTER TABLE "CLASSROOM" MODIFY ("ROOM_NO" NOT NULL ENABLE);
 
  ALTER TABLE "CLASSROOM" MODIFY ("MAX_SEAT" NOT NULL ENABLE);
 
  ALTER TABLE "CLASSROOM" ADD PRIMARY KEY ("CLASSROOM_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table COURSE
--------------------------------------------------------

  ALTER TABLE "COURSE" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE" MODIFY ("COURSE_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE" MODIFY ("COURSE_FEE" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE" MODIFY ("COURSE_START" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE" MODIFY ("COURSE_END" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE" ADD PRIMARY KEY ("COURSE_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table COURSE_SCHEDULE
--------------------------------------------------------

  ALTER TABLE "COURSE_SCHEDULE" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_SCHEDULE" MODIFY ("BEGIN_TIME" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_SCHEDULE" MODIFY ("END_TIME" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_SCHEDULE" MODIFY ("HOURS" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_SCHEDULE" MODIFY ("SCHEDULE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_SCHEDULE" ADD PRIMARY KEY ("SCHEDULE_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table COURSE_TRAINER
--------------------------------------------------------

  ALTER TABLE "COURSE_TRAINER" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_TRAINER" MODIFY ("TRAINER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "COURSE_TRAINER" ADD PRIMARY KEY ("COURSE_ID", "TRAINER_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table DEPARTMENT
--------------------------------------------------------

  ALTER TABLE "DEPARTMENT" MODIFY ("DEP_ID" NOT NULL ENABLE);
 
  ALTER TABLE "DEPARTMENT" MODIFY ("DEPARTMENT_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "DEPARTMENT" ADD PRIMARY KEY ("DEP_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table EXAM
--------------------------------------------------------

  ALTER TABLE "EXAM" MODIFY ("EXAM_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EXAM" MODIFY ("ITEM" NOT NULL ENABLE);
 
  ALTER TABLE "EXAM" MODIFY ("QUESTION" NOT NULL ENABLE);
 
  ALTER TABLE "EXAM" ADD PRIMARY KEY ("ITEM") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table EXAM_SERIES
--------------------------------------------------------

  ALTER TABLE "EXAM_SERIES" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "EXAM_SERIES" MODIFY ("EXAM_NO" NOT NULL ENABLE);
 
  ALTER TABLE "EXAM_SERIES" MODIFY ("FULL_SCORE" NOT NULL ENABLE);
 
  ALTER TABLE "EXAM_SERIES" ADD PRIMARY KEY ("EXAM_NO") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table STD_PROFILE
--------------------------------------------------------

  ALTER TABLE "STD_PROFILE" MODIFY ("ID_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("FIRSTNAME" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("LASTNAME" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("ADDRESS" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("PROVINCE" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("PHONE_NO" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("EMAIL" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("INSTITUTE_NAME" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("EDU_LEVEL" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("GPA" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" MODIFY ("REGISTERED_DATE" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" ADD PRIMARY KEY ("ID_CODE") ENABLE;
 
  ALTER TABLE "STD_PROFILE" MODIFY ("ID_NUMBER" NOT NULL ENABLE);
 
  ALTER TABLE "STD_PROFILE" ADD CONSTRAINT "UNQ_ID_NUMBER" UNIQUE ("ID_NUMBER") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table TAKE_EXAM
--------------------------------------------------------

  ALTER TABLE "TAKE_EXAM" MODIFY ("ID_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "TAKE_EXAM" MODIFY ("ITEM" NOT NULL ENABLE);
 
  ALTER TABLE "TAKE_EXAM" MODIFY ("ANS" NOT NULL ENABLE);
 
  ALTER TABLE "TAKE_EXAM" MODIFY ("TEST_DATE" NOT NULL ENABLE);
 
  ALTER TABLE "TAKE_EXAM" ADD PRIMARY KEY ("ID_CODE", "ITEM") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table TRAINEE_GRADE
--------------------------------------------------------

  ALTER TABLE "TRAINEE_GRADE" MODIFY ("ID_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINEE_GRADE" MODIFY ("COURSE_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINEE_GRADE" MODIFY ("EXAM_NO" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINEE_GRADE" ADD PRIMARY KEY ("ID_CODE", "COURSE_ID", "EXAM_NO") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table TRAINER_PROFILE
--------------------------------------------------------

  ALTER TABLE "TRAINER_PROFILE" MODIFY ("TRAINER_ID" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINER_PROFILE" MODIFY ("FIRSTNAME" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINER_PROFILE" MODIFY ("LASTNAME" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINER_PROFILE" MODIFY ("PHONE_NO" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINER_PROFILE" MODIFY ("EMAIL" NOT NULL ENABLE);
 
  ALTER TABLE "TRAINER_PROFILE" ADD PRIMARY KEY ("TRAINER_ID") ENABLE;
/
--------------------------------------------------------
--  Constraints for Table USER_LOGIN
--------------------------------------------------------

  ALTER TABLE "USER_LOGIN" MODIFY ("ID_CODE" NOT NULL ENABLE);
 
  ALTER TABLE "USER_LOGIN" MODIFY ("USERNAME" NOT NULL ENABLE);
 
  ALTER TABLE "USER_LOGIN" MODIFY ("PASSWD" NOT NULL ENABLE);
 
  ALTER TABLE "USER_LOGIN" MODIFY ("LAST_LOGIN" NOT NULL ENABLE);
 
  ALTER TABLE "USER_LOGIN" ADD PRIMARY KEY ("ID_CODE") ENABLE;
 
  ALTER TABLE "USER_LOGIN" ADD CONSTRAINT "UNQ_USERNAME" UNIQUE ("USERNAME") ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table CBS_COURSE
--------------------------------------------------------

  ALTER TABLE "CBS_COURSE" ADD CONSTRAINT "FK_COURSE" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "COURSE" ("COURSE_ID") ON DELETE CASCADE ENABLE;
 
  ALTER TABLE "CBS_COURSE" ADD CONSTRAINT "FK_DEPT_COURSE" FOREIGN KEY ("CBS_ID")
	  REFERENCES "CBS_DEPARTMENTS" ("CBS_ID") ON DELETE CASCADE ENABLE;
/

--------------------------------------------------------
--  Ref Constraints for Table CBS_PREFERED
--------------------------------------------------------

  ALTER TABLE "CBS_PREFERED" ADD CONSTRAINT "FK_CBS_DEPT" FOREIGN KEY ("CBS_ID")
	  REFERENCES "CBS_DEPARTMENTS" ("CBS_ID") ON DELETE CASCADE ENABLE;
 
  ALTER TABLE "CBS_PREFERED" ADD CONSTRAINT "FK_STD_PROFILE" FOREIGN KEY ("ID_CODE")
	  REFERENCES "STD_PROFILE" ("ID_CODE") ON DELETE CASCADE ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table CLASS
--------------------------------------------------------

  ALTER TABLE "CLASS" ADD CONSTRAINT "FK_CLASS_COURSE" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "COURSE" ("COURSE_ID") ON DELETE CASCADE ENABLE;
 
  ALTER TABLE "CLASS" ADD CONSTRAINT "FK_COURSE_CLASS" FOREIGN KEY ("CLASSROOM_ID")
	  REFERENCES "CLASSROOM" ("CLASSROOM_ID") ON DELETE CASCADE ENABLE;
/


--------------------------------------------------------
--  Ref Constraints for Table COURSE_SCHEDULE
--------------------------------------------------------

  ALTER TABLE "COURSE_SCHEDULE" ADD CONSTRAINT "FK_SCHD_COURSE" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "COURSE" ("COURSE_ID") ON DELETE CASCADE ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table COURSE_TRAINER
--------------------------------------------------------

  ALTER TABLE "COURSE_TRAINER" ADD CONSTRAINT "FK_COURSE_TRAINER" FOREIGN KEY ("TRAINER_ID")
	  REFERENCES "TRAINER_PROFILE" ("TRAINER_ID") ON DELETE CASCADE ENABLE;
 
  ALTER TABLE "COURSE_TRAINER" ADD CONSTRAINT "FK_TRAINER_COURSE" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "COURSE" ("COURSE_ID") ON DELETE CASCADE ENABLE;
/

--------------------------------------------------------
--  Ref Constraints for Table EXAM
--------------------------------------------------------

  ALTER TABLE "EXAM" ADD CONSTRAINT "FK_EXAM_SERIES" FOREIGN KEY ("EXAM_NO")
	  REFERENCES "EXAM_SERIES" ("EXAM_NO") ON DELETE CASCADE ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table EXAM_SERIES
--------------------------------------------------------

  ALTER TABLE "EXAM_SERIES" ADD CONSTRAINT "FK_EXAM_COURSE" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "COURSE" ("COURSE_ID") ON DELETE SET NULL ENABLE;
/

--------------------------------------------------------
--  Ref Constraints for Table TAKE_EXAM
--------------------------------------------------------

  ALTER TABLE "TAKE_EXAM" ADD CONSTRAINT "FK_EXAM_EXAM" FOREIGN KEY ("ITEM")
	  REFERENCES "EXAM" ("ITEM") ON DELETE CASCADE ENABLE;
 
  ALTER TABLE "TAKE_EXAM" ADD CONSTRAINT "FK_EXAM_STD" FOREIGN KEY ("ID_CODE")
	  REFERENCES "STD_PROFILE" ("ID_CODE") ON DELETE CASCADE ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table TRAINEE_GRADE
--------------------------------------------------------

  ALTER TABLE "TRAINEE_GRADE" ADD CONSTRAINT "FK_GRADE_COURSE" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "COURSE" ("COURSE_ID") ON DELETE CASCADE ENABLE;
 
  ALTER TABLE "TRAINEE_GRADE" ADD CONSTRAINT "FK_GRADE_SERIES" FOREIGN KEY ("EXAM_NO")
	  REFERENCES "EXAM_SERIES" ("EXAM_NO") ON DELETE SET NULL ENABLE;
 
  ALTER TABLE "TRAINEE_GRADE" ADD CONSTRAINT "FK_GRADE_STD" FOREIGN KEY ("ID_CODE")
	  REFERENCES "STD_PROFILE" ("ID_CODE") ON DELETE CASCADE ENABLE;
/
--------------------------------------------------------
--  Ref Constraints for Table TRAINER_PROFILE
--------------------------------------------------------

  ALTER TABLE "TRAINER_PROFILE" ADD CONSTRAINT "FK_TRAINER_DEPT" FOREIGN KEY ("DEP_ID")
	  REFERENCES "DEPARTMENT" ("DEP_ID") ON DELETE SET NULL ENABLE;
/

