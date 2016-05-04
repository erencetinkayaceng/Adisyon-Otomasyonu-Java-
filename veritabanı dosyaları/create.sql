--Database Oluþturma
CREATE DATABASE "dpuLokantaAdisyon"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Turkish_Turkey.1254'
       LC_CTYPE = 'Turkish_Turkey.1254'
       CONNECTION LIMIT = -1;
	   
-- Sipariþ  Tablosu
CREATE TABLE public.siparis
(
  id integer NOT NULL,
  y_id integer[],
  CONSTRAINT "Siparis_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.siparis
  OWNER TO postgres;

--Yemekler Tablosu
CREATE TABLE public.yemekler
(
  id integer NOT NULL,
  y_adi text NOT NULL,
  y_turu text NOT NULL,
  y_bilgisi text NOT NULL,
  y_fiyat double precision,
  CONSTRAINT "Yemekler_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.yemekler
  OWNER TO postgres;
  
--Rezervasyon Tablosu
CREATE TABLE public.rezervasyon
(
  id integer NOT NULL,
  masano integer,
  tarihi text,
  saat text,
  CONSTRAINT "Rezervasyon_pkey" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.rezervasyon
  OWNER TO postgres;
  
--Menü Tablosu
CREATE TABLE public.menu
(
  id integer NOT NULL,
  yemek_id integer NOT NULL,
  CONSTRAINT "Menu_pkey" PRIMARY KEY (id),
  CONSTRAINT "Menu_yemek_id_fkey" FOREIGN KEY (yemek_id)
      REFERENCES public.yemekler (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.menu
  OWNER TO postgres;
  
 --Masa Tablosu
CREATE TABLE public.masa
(
  id integer NOT NULL,
  masano integer NOT NULL,
  rezervasyon_id integer,
  siparis_id integer[],
  CONSTRAINT "Masa_pkey" PRIMARY KEY (id),
  CONSTRAINT "Masa_rezervasyon_id_fkey" FOREIGN KEY (rezervasyon_id)
      REFERENCES public.rezervasyon (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.masa
  OWNER TO postgres;



