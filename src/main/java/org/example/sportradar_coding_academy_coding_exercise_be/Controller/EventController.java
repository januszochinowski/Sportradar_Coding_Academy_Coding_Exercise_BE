package org.example.sportradar_coding_academy_coding_exercise_be.Controller;

import org.example.sportradar_coding_academy_coding_exercise_be.Model.Event;
import org.example.sportradar_coding_academy_coding_exercise_be.Service.EventService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controller to manage Events
 */
@RestController
@RequestMapping("/api/event")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * Get Event by ID
     * @param id id of selected Event
     * @return selected Event if exist
     */
    @GetMapping("/{id}")
    public Event getById(@PathVariable long id){
        return eventService.getById(id);
    }

    /**
     * Get events
     * @param page page number
     * @param size number of elements in a page
     */
    @GetMapping("/get_all")
    public List<Event> getAll(@RequestParam int page, @RequestParam int size){
        return  eventService.getAll(page, size);
    }

    /**
     *Get events with selected place
     *@param page page number
     *@param size number of elements in a page
     *@param placeName name of selected place
     */
    @GetMapping("/getByPlace")
    public List<Event> getByPlace(@RequestParam(name= "place") String placeName,
                                  @RequestParam int page,
                                  @RequestParam int size){
        return eventService.getByPlace(placeName, page, size);
    }

    /**
     * Get Events with date after selected date
     * @param page page number
     *@param size number of elements in a page
     * @param date search Event after this date
     */
    @GetMapping("/afterDate")
    public List<Event> getAfterDate(@RequestParam LocalDate date,
                                    @RequestParam int page,
                                    @RequestParam int size){
        return eventService.getByAfter(date,page,size);
    }

    /**
     * Get events with date between two selected dates
     */
    @GetMapping("/between")
    public List<Event> getBetween(@RequestParam("from") LocalDate start,
                                  @RequestParam("to") LocalDate end,
                                  @RequestParam int page,
                                  @RequestParam int size){
        return eventService.getByBetween(start,end,page,size);
    }

    /**
     * Get events with selected sport
     */
    @GetMapping("/sportName")
    public List<Event> getSportName(@RequestParam String sportName,
                                    @RequestParam int page,
                                    @RequestParam int size){
        return eventService.getBySportName(sportName,page,size);
    }

    /**
     * Create new Event
     * @param event new Event
     */
    @PostMapping()
    public void create(@RequestBody Event event){
        eventService.add(event);
    }

    /**
     * Update Event
     * @param event data to update
     */
    @PatchMapping()
    public void update(@RequestBody Event event){
        eventService.update(event);
    }

    /**
     * Delete Event
     * @param id ID Event to delete
     */
    @DeleteMapping()
    public void delete(@RequestParam long id){
        eventService.delete(id);
    }
}
