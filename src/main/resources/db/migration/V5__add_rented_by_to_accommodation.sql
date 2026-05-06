ALTER TABLE accommodation ADD COLUMN IF NOT EXISTS rented_by_id BIGINT;

DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM pg_constraint WHERE conname = 'fk_rented_by' AND conrelid = 'accommodation'::regclass) THEN
ALTER TABLE accommodation ADD CONSTRAINT fk_rented_by FOREIGN KEY (rented_by_id) REFERENCES users(id);
END IF;
END $$;