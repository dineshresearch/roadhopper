/*
 * Copyright (c) 2015 Andreas Wolf
 *
 * See te LICENSE file in the project root for further copyright information.
 */

package info.andreaswolf.roadhopper.road

import com.graphhopper.util.shapes.GHPoint3D

/**
 * Flexible builder class for road segments.
 */
class RoadSegmentBuilder {

	private var _start: Option[GHPoint3D] = None
	private var _end: Option[GHPoint3D] = None

	private var _speedLimit: Option[Double] = None

	def start = _start

	def start_=(point: GHPoint3D) = _start = Some(point)

	def start(point: GHPoint3D): RoadSegmentBuilder = {
		this.start = point
		this
	}

	def start(lat: Double, lon: Double, ele: Double): RoadSegmentBuilder = {
		this.start = new GHPoint3D(lat, lon, ele)
		this
	}


	def end = _start

	def end_=(point: GHPoint3D) = _end = Some(point)

	def end(point: GHPoint3D): RoadSegmentBuilder = {
		this.end = point
		this
	}

	def end(lat: Double, lon: Double, ele: Double): RoadSegmentBuilder = {
		this.end = new GHPoint3D(lat, lon, ele)
		this
	}


	def speedLimit = _speedLimit

	def speedLimit_=(speed: Double) = _speedLimit = Some(speed)

	def speedLimit(speed: Double): RoadSegmentBuilder = {
		this.speedLimit = speed
		this
	}


	def build = {
		if (_speedLimit.isDefined) {
			new RoadSegment(_start.get, _end.get, speedLimit = _speedLimit.get)
		} else {
			RoadSegment.fromPoints(_start.get, _end.get)
		}
	}
}