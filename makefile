T :
	@echo sql - Jump to sql database
	@echo migrate - ragtime migrate

sql : 
	psql -d ksafe

migrate : 
	lein ragtime migrate
