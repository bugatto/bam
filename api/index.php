<?php

use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;

include 'src/schema/Dish.php';
require 'vendor/autoload.php';

$app = new \Slim\Slim();

$app->get('/hello/:name', function ($name) {
    echo "Hello, $name";
});

$app->get('/test', function () use ($app) {

    $config = Setup::createAnnotationMetadataConfiguration(array(__DIR__."/src/schema"), true);
    // Set up database connection data
    $conn = array(
        'driver'   => 'pdo_mysql',
        'host'     => '192.168.59.103',
        'port'     => '3322',
        'dbname'   => 'bam',
        'user'     => 'root',
        'password' => 'root'
    );

    $entityManager = EntityManager::create($conn, $config);

    $dishes = $entityManager->getRepository('Dish')->findAll();
    echo $dishes[0]->getName();
});

$app->run();

