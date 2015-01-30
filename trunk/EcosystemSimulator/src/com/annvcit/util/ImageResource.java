package com.annvcit.util;

import java.net.URL;

public interface ImageResource {
	
	URL LION_MALE_NORMAL = ImageResource.class.getResource("/tiles/lion_male_nomal.png");
	URL LION_MALE_DEAD = ImageResource.class.getResource("/tiles/lion_male_dead.png");
	URL LION_MALE_CHILD_NORMAL = ImageResource.class.getResource("/tiles/lion_male_child_normal.png");
	URL LION_FEMALE_NORMAL = ImageResource.class.getResource("/tiles/lion_female_normal.png");
	URL LION_FEMALE_DEAD = ImageResource.class.getResource("/tiles/lion_female_dead.png");
	URL LION_FEMALE_CHILD_NORMAL = ImageResource.class.getResource("/tiles/lion_female_child_normal.png");
	
	URL GRASS_TILE = ImageResource.class.getResource("/tiles/grass_tile.png");
	URL GRASS_DEAD_TILE = ImageResource.class.getResource("/tiles/grass_dead_tile.png");
	
	URL LAND_TILE = ImageResource.class.getResource("/tiles/land_tile.png");

	URL ANTELOPE_MALE_NORMAL = ImageResource.class.getResource("/tiles/antelope_male_normal.png");
	URL ANTELOPE_FEMALE_NORMAL = ImageResource.class.getResource("/tiles/antelope_female_normal.png");
	URL ANTELOPE_MALE_DEAD = ImageResource.class.getResource("/tiles/antelope_male_dead.png");
	URL ANTELOPE_FEMALE_DEAD = ImageResource.class.getResource("/tiles/antelope_female_dead.png");

}
