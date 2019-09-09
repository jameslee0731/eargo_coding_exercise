--update the output_table
update output_table
--    update based on page type
    set output_table.counts = case Page
        when 'Home_Page' then (select sum(Home_Page) from input_table)
        when 'Product_Page' then (select sum(Product_Page) from input_table)
        when 'Warranty_Page' then (select sum(Warranty_Page) from input_table)
    end
where Page in ('Home_Page', 'Product_Page', 'Warranty_Page');