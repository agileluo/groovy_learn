assert "123456" =~ /\d+/

assert "xxxxxx" == "123456".replaceAll(/\d/, "x")