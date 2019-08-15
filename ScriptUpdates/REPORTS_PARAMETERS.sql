   FUNCTION gettrusteesnames (v_endr_code NUMBER)
      RETURN VARCHAR2
   IS
      v_names   VARCHAR2 (500) := NULL;
      v_count   NUMBER :=0;

      CURSOR cur
      IS
         SELECT   rownum num, INITCAP (lpt_surname)
                || ' '
                || INITCAP (lpt_other_names)||' of '||lpt_address trustee_name
           FROM lms_pension_trustees
          WHERE lpt_endr_code = v_endr_code;
   BEGIN
      BEGIN
        SELECT  COUNT('X') 
            INTO v_count
           FROM lms_pension_trustees
          WHERE lpt_endr_code = v_endr_code;
      EXCEPTION 
            WHEN OTHERS THEN
                RAISE_ERROR('2... ERROR COUNTING THE NUMBER OF TRUSTEES IN ENDORSEMENT....');
       
      END;
      
      FOR cur_rec IN cur
      LOOP
         IF cur_rec.num =1 THEN  
            v_names := cur_rec.trustee_name;
         ELSIF cur_rec.num >1 AND cur_rec.num <v_count THEN
            v_names := v_names || ',' || cur_rec.trustee_name;
         ELSE
            v_names := v_names || ' and ' || cur_rec.trustee_name;
         END IF;
      END LOOP;

     /* IF v_names IS NOT NULL
      THEN
         v_names :=
            REPLACE (v_names,
                     ',' || SUBSTR (v_names, INSTR (v_names, ',', -1, 1) + 1),
                     ' and '
                     || SUBSTR (v_names, INSTR (v_names, ',', -1, 1) + 1)
                    );
         v_names := SUBSTR (v_names, 2);
      END IF;*/

      RETURN v_names;
   END;