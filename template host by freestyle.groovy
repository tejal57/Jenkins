template host by freestyle  


sudo apt update
sudo apt install apache2 -y
sudo systemctl start apache
sudo apt install unzip -y
sudo wget https://www.free-css.com/assets/files/free-css-templates/download/page296/little-fashion.zip
sudo rm -rf /var/www/html/*
sudo unzip little-fashion.zip
sudo mv little-fashion.html/* /var/www/html/