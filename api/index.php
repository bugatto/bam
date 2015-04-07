<?php

use Doctrine\ORM\Tools\Setup;
use Doctrine\ORM\EntityManager;

include 'src/schema/Dish.php';
require 'vendor/autoload.php';

$app = new \Slim\Slim();

function entityManager() {
    $config = Setup::createAnnotationMetadataConfiguration(array(__DIR__."/src"), true);
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
    return $entityManager;
}

$app->get('/hello/:name', function ($name) {
    echo "Hello, $name";
});

$app->get('/test', function () use ($app) {

    $dishes = entityManager()->getRepository('Dish')->findAll();
    foreach ($dishes as $dish) {
        echo $dish->getName()."<br/>";
    }
});

$app->get('/test/:name', function ($name) {

    $dish = new Dish();
    $dish->setName($name);
    $entityManager = entityManager();
    $entityManager->persist($dish);
    $entityManager->flush();
});

$app->run();

