FROM ubuntu:14.04

#RUN adduser www-data --disabled-password --gecos ""
RUN echo "www-data:www-data" | chpasswd
RUN sed -i 's/^.*\%sudo.*$/\%sudo        ALL=(ALL)       NOPASSWD: ALL/' /etc/sudoers
RUN usermod -aG sudo www-data

# Install base packages
RUN apt-get update && \
    DEBIAN_FRONTEND=noninteractive apt-get -yq install \
        curl \
        apache2 \
        libapache2-mod-php5 \
        php5-mysql \
        php5-gd \
        php5-curl \
        php5-pgsql \
        php-pear \
        php-apc && \
    rm -rf /var/lib/apt/lists/* && \
    curl -sS https://getcomposer.org/installer | php -- --install-dir=/usr/local/bin --filename=composer
RUN echo "ServerName localhost" >> /etc/apache2/apache2.conf && \
    sed -i "s/variables_order.*/variables_order = \"EGPCS\"/g" /etc/php5/apache2/php.ini

# Add image configuration and scripts
ADD run.sh /run.sh
RUN chmod 755 /*.sh

# Configure /app folder with sample app
RUN mkdir -p /app && rm -fr /var/www/html && ln -s /app /var/www/html
#ADD sample/ /app

ADD apache_default /etc/apache2/sites-available/000-default.conf
RUN a2enmod rewrite

EXPOSE 80
WORKDIR /app
CMD ["/run.sh"]
