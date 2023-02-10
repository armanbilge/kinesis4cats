/*
 * Copyright 2023-2023 etspaceman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kinesis4cats
package producer
package logging.instances

import cats.Show

import kinesis4cats.logging.instances.show._
import kinesis4cats.models._

object show {
  implicit val shardIdShow: Show[ShardId] = _.shardId

  implicit val recordShow: Show[Record] = x =>
    ShowBuilder("Record")
      .add("data", x.data)
      .add("partitionKey", x.partitionKey)
      .add("explicitHashKey", x.explicitHashKey)
      .build

  implicit val hashKeyRangeShow: Show[HashKeyRange] = x =>
    ShowBuilder("HashKeyRange")
      .add("endingHashKey", x.endingHashKey)
      .add("startingHashKey", x.startingHashKey)
      .build

  implicit val shardMapRecordShow: Show[ShardMapRecord] = x =>
    ShowBuilder("ShardMapRecord")
      .add("shardId", x.shardId)
      .add("hashKeyRange", x.hashKeyRange)
      .build

  implicit val shardMapShow: Show[ShardMap] = x =>
    ShowBuilder("ShardMap")
      .add("lastUpdated", x.lastUpdated)
      .add("shards", x.shards)
      .build

  implicit val shardMapCacheLogEncoders: ShardMapCache.LogEncoders =
    new ShardMapCache.LogEncoders()
}
